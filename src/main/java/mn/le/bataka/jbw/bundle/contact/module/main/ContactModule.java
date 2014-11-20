
package mn.le.bataka.jbw.bundle.contact.module.main;

import mn.le.farcek.common.NamedContainer;
import mn.le.farcek.jbw.api.IAction;
import mn.le.farcek.jbw.api.IBundle;
import mn.le.farcek.jbw.api.module.JBWAbstractModule;

public class ContactModule extends JBWAbstractModule {

    public ContactModule() {
    }

    public ContactModule(IBundle bundle) {
        super(bundle);
    }

    @Override
    public void setupActions(NamedContainer<IAction> actions) {
        actions.add(new ContactActions(this).getActions());
    }

    @Override
    public String getName() {
        return "main";
    }

}
