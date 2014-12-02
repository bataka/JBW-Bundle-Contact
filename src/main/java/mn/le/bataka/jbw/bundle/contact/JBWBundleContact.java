package mn.le.bataka.jbw.bundle.contact;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import mn.le.bataka.jbw.bundle.contact.assets.AssetLoaderContactBundle;
import mn.le.bataka.jbw.bundle.contact.module.admin.ContactAdminModule;
import mn.le.bataka.jbw.bundle.contact.module.main.ContactActions;
import mn.le.bataka.jbw.bundle.contact.module.main.ContactModule;
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

    Properties conf;

    public Properties getContactConfig() {
        if (conf == null) {
            conf = new Properties();
            try {
                conf.load(new FileReader(getContext().getConfig().getConfigDir() + File.separator + "contact.config"));
            } catch (IOException ex) {

            }
        }
        return conf;
    }
}
