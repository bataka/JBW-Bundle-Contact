package mn.le.bataka.jbw.bundle.contact.module.main;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import mn.le.bataka.jbw.bundle.contact.entity.ContactEntity;
import mn.le.bataka.jbw.bundle.contact.entity.ContactMapEntity;
import mn.le.bataka.jbw.bundle.contact.entity.ContactMarkerEntity;
import mn.le.farcek.common.NamedContainer;
import mn.le.farcek.common.entity.criteria.BinaryOperator;
import mn.le.farcek.common.entity.criteria.FilterItem;
import mn.le.farcek.jbw.api.IAction;
import mn.le.farcek.jbw.api.IModule;
import mn.le.farcek.jbw.api.action.ActionParamHelper;
import mn.le.farcek.jbw.api.action.ActionParamInfo;
import mn.le.farcek.jbw.api.action.ActionResult;
import mn.le.farcek.jbw.api.action.IActionParam;
import mn.le.farcek.jbw.api.action.IActionResult;
import mn.le.farcek.jbw.api.action.JBWAbstractAction;
import mn.le.farcek.jbw.api.action.JBWAbstractGetAction;
import mn.le.farcek.jbw.api.action.JBWAbstractPostAction;
import mn.le.farcek.jbw.api.action.JBWPackageActions;
import mn.le.farcek.jbw.core.content.ContentEntity;

public class ContactActions extends JBWPackageActions {

    public ContactActions(IModule module) {
        super(module);
    }

    @Override
    public void setupActions(NamedContainer<IAction> actions, IModule module) {
        actions.add(new index().setModule(module));
        actions.add(new map().setModule(module));
        actions.add(new form().setModule(module));
        actions.add(new formPost().setModule(module));
        actions.add(new info().setModule(module));
    }

    private List<ContactMarkerEntity> getMapInfos() {
        List<ContactMarkerEntity> list = getService().entitysBy(ContactMarkerEntity.class, (FilterItem[]) null);
        return list;
    }
    private ContactMapEntity getMap() {
        ContactMapEntity map = getService().entityBy(ContactMapEntity.class, new BinaryOperator("mapKey", "main"));
        return map;
    }

    private ContentEntity getInfo() {
        ContentEntity entity = getService().entityBy(ContentEntity.class, new BinaryOperator("keyName", "contactInfo"));
        return entity;
    }

    public class index extends JBWAbstractGetAction {

        @Override
        public IActionResult execut(IActionParam actionParam) {

            return new ActionResult()
                    .add("info", getInfo())
                    .add("map", getMap())
                    .add("markers", getMapInfos())
                    .add("offerTypes", Arrays.asList(ContactEntity.OfferType.values()));
        }

        @Override
        public ActionType getActionType() {
            return ActionType.Page;
        }

        @Override
        public NamedContainer<ActionParamInfo> getRequaredActionParams() {
            return new NamedContainer<>();
        }

    }

    public class map extends JBWAbstractAction {

        @Override
        public IActionResult execut(IActionParam actionParam) {
            return new ActionResult("//map")
                    .add("map", getMap())
                    .add("markers", getMapInfos());
        }

        @Override
        public ActionType getActionType() {
            return ActionType.Sector;
        }
    }

    public class form extends JBWAbstractAction {

        @Override
        public IActionResult execut(IActionParam actionParam) {

            return new ActionResult("//form").add("offerTypes", Arrays.asList(ContactEntity.OfferType.values()));
        }

        @Override
        public ActionType getActionType() {
            return ActionType.Sector;
        }
    }

    public class formPost extends JBWAbstractPostAction {

        @Override
        public IActionResult execut(IActionParam actionParam) {
            ActionParamHelper paramHelper = new ActionParamHelper(actionParam);
            ContactEntity entity = new ContactEntity();

            String offerType = paramHelper.getParameterString("offerType", "Санал");
            String lastname = paramHelper.getParameterString("lastname", "");
            String firstname = paramHelper.getParameterString("firstname", "");
            String email = paramHelper.getParameterString("email", "");
            String offer = paramHelper.getParameterString("offer", "");

            entity.setOfferType(ContactEntity.OfferType.valueOf(offerType));
            entity.setLastname(lastname);
            entity.setFirstname(firstname);
            entity.setEmail(email);
            entity.setOffer(offer);

            try {
                getService().doCreate(ContactEntity.class, entity);
            } catch (Exception ex) {
                Logger.getLogger(ContactActions.class.getName()).log(Level.SEVERE, null, ex);
            }

            return new ActionResult("//index").add("info", getInfo()).add("markers", getMapInfos()).add("offerTypes", Arrays.asList(ContactEntity.OfferType.values()));
        }

        @Override
        public IAction.ActionType getActionType() {
            return IAction.ActionType.Other;
        }
    }

    public class info extends JBWAbstractAction {

        @Override
        public IActionResult execut(IActionParam actionParam) {
            return new ActionResult("//info").add("info", getInfo());
        }

        @Override
        public ActionType getActionType() {
            return ActionType.Sector;
        }
    }

}
