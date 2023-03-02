package ca.sylvain.jpurcellswingtutorial;

import javax.swing.filechooser.FileFilter;
import java.io.File;

class PersonFileFilter extends FileFilter {
    @Override
    public boolean accept(File f) {
        String name = f.getName();

        String extension = Utils.getFileExtension(name);

        if (extension == null) {
            return false;
        } else {
            return extension.equals(".per");
        }

    }

    @Override
    public String getDescription() {
        return "Person database files (*.per)";
    }
}
