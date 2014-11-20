
package mn.le.bataka.jbw.bundle.contact;


import mn.le.bataka.jbw.bundle.contact.module.main.ContactModule;
import mn.le.bataka.jbw.bundle.contact.assets.AssetLoaderContactBundle;
import mn.le.bataka.jbw.bundle.contact.module.admin.ContactAdminModule;
import mn.le.farcek.common.NamedContainer;
import mn.le.farcek.jbw.api.IModule;
import mn.le.farcek.jbw.api.bundle.JBWAbstractBundle;

public class JBWBundleContact extends JBWAbstractBundle {

    @Override
    public void setupModules(NamedContainer<IModule> modules) {
        modules.add(new ContactModule(this));
        modules.add(new ContactAdminModule(this));
    }

    @Override
    protected Class getAssetReaderClass() {
        return AssetLoaderContactBundle.class;
    }

    @Override
    public String getName() {
        return "contact";
    }

}
