package mn.le.bataka.jbw.bundle.contact.module.admin;

import mn.le.farcek.common.NamedContainer;
import mn.le.farcek.jbw.api.IAction;
import mn.le.farcek.jbw.api.IBundle;
import mn.le.farcek.jbw.api.module.JBWAbstractModule;

public class ContactAdminModule extends JBWAbstractModule {

    public ContactAdminModule() {
    }

    public ContactAdminModule(IBundle bundle) {
        super(bundle);
    }

    @Override
    public void setupActions(NamedContainer<IAction> actions) {
        actions.add(new ContactMarkerAdminActions(this).getActions());
        actions.add(new ContactInfoAdminActions(this).getActions());
        actions.add(new ContactMapAdminActions(this).getActions());
    }

    @Override
    public String getName() {
        return "admin";
    }

}
