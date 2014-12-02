package mn.le.bataka.jbw.bundle.contact.module.admin;

import java.util.Arrays;
import java.util.List;
import mn.le.bataka.jbw.bundle.contact.entity.ContactEntity;
import mn.le.bataka.jbw.bundle.contact.entity.ContactMarkerEntity;
import mn.le.farcek.common.NamedContainer;
import mn.le.farcek.jbw.api.IAction;
import mn.le.farcek.jbw.api.IModule;
import mn.le.farcek.jbw.api.action.ActionParamHelper;
import mn.le.farcek.jbw.api.action.ActionResult;
import mn.le.farcek.jbw.api.utils.SampleCrudActions;

public class ContactMarkerAdminActions extends SampleCrudActions<ContactMarkerEntity> {

    public ContactMarkerAdminActions(IModule module) {
        super(ContactMarkerEntity.class, "contactMarker", module);
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
        List<ContactMarkerEntity> list = getService().entitysBy(ContactMarkerEntity.class);
        return new ActionResult("//marker-index").add("list", list).add("listType", Arrays.asList(ContactMarkerEntity.MarkerType.values()));
    }

    @Override
    protected void fillFromRequest(ContactMarkerEntity entity, FillFromRequestParam param) {
        entity.setTitle(param.getParamHelper().getParameterString("title", null));
        entity.setDescription(param.getParamHelper().getParameterString("description", null));
        entity.setLatitude(param.getParamHelper().getParameterDouble("latitude", null));
        entity.setLongitude(param.getParamHelper().getParameterDouble("longitude", null));
        String markerType = param.getParamHelper().getParameterString("markerType", "Home");
        entity.setMarkerType(ContactMarkerEntity.MarkerType.valueOf(markerType));
    }
}
