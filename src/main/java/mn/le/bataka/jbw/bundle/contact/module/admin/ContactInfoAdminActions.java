package mn.le.bataka.jbw.bundle.contact.module.admin;

import java.util.Arrays;
import java.util.List;
import mn.le.bataka.jbw.bundle.contact.entity.ContactEntity;
import mn.le.farcek.common.NamedContainer;
import mn.le.farcek.jbw.api.IAction;
import mn.le.farcek.jbw.api.IModule;
import mn.le.farcek.jbw.api.action.ActionParamHelper;
import mn.le.farcek.jbw.api.action.ActionResult;
import mn.le.farcek.jbw.api.utils.SampleCrudActions;

public class ContactInfoAdminActions extends SampleCrudActions<ContactEntity> {

    public ContactInfoAdminActions(IModule module) {
        super(ContactEntity.class, "contactInfo", module);
    }

    @Override
    public void setupActions(NamedContainer<IAction> actions, IModule module) {
        super.setupActions(actions, module);
    }

    @Override
    protected String getRole() {
        return "admin";
    }

    @Override
    protected ActionResult factoryActionResult(ActionParamHelper paramHelper) {
        List<ContactEntity> list = getService().entitysBy(ContactEntity.class);
        return new ActionResult("//info-index").add("list", list).add("offerTypes", Arrays.asList(ContactEntity.OfferType.values()));
    }

    @Override
    protected void fillFromRequest(ContactEntity entity, FillFromRequestParam param) {
        entity.setLastname(param.getParamHelper().getParameterString("lastname", null));
        entity.setFirstname(param.getParamHelper().getParameterString("firstname", null));
        entity.setEmail(param.getParamHelper().getParameterString("email", null));
        entity.setOffer(param.getParamHelper().getParameterString("offer", null));
        String offerType = param.getParamHelper().getParameterString("offerType", "Санал");
        entity.setOfferType(ContactEntity.OfferType.valueOf(offerType));
    }
}
