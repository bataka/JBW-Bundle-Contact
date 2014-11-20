package mn.le.bataka.jbw.bundle.contact.module.admin;

import java.util.List;
import mn.le.bataka.jbw.bundle.contact.entity.ContactMapEntity;
import mn.le.farcek.common.NamedContainer;
import mn.le.farcek.jbw.api.IAction;
import mn.le.farcek.jbw.api.IModule;
import mn.le.farcek.jbw.api.action.ActionParamHelper;
import mn.le.farcek.jbw.api.action.ActionResult;
import mn.le.farcek.jbw.api.utils.SampleCrudActions;

public class ContactMapAdminActions extends SampleCrudActions<ContactMapEntity> {

    public ContactMapAdminActions(IModule module) {
        super(ContactMapEntity.class, "contactMap", module);
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
        List<ContactMapEntity> list = getService().entitysBy(ContactMapEntity.class);
        return new ActionResult("//map-index").add("list", list);
    }

    @Override
    protected void fillFromRequest(ContactMapEntity entity, FillFromRequestParam param) {
        entity.setCenterLat(param.getParamHelper().getParameterDouble("centerLat", 47.91001390193467));
        entity.setCenterLong(param.getParamHelper().getParameterDouble("centerLong", 106.90006256103516));
        entity.setZoom(param.getParamHelper().getParameterInteger("zoom", 12));
        entity.setMapKey(param.getParamHelper().getParameterString("mapKey", null));
    }
}
