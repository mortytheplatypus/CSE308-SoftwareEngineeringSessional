package mortytheplatypus.Problem2;

import mortytheplatypus.Problem2.Fonts.Consolas;
import mortytheplatypus.Problem2.Fonts.CourierNew;
import mortytheplatypus.Problem2.Fonts.Font;
import mortytheplatypus.Problem2.Fonts.Monaco;
import mortytheplatypus.Problem2.Language.C;
import mortytheplatypus.Problem2.Language.CPP;
import mortytheplatypus.Problem2.Language.Language;
import mortytheplatypus.Problem2.Language.Python;
import mortytheplatypus.Problem2.Parsers.CPPParser;
import mortytheplatypus.Problem2.Parsers.CParser;
import mortytheplatypus.Problem2.Parsers.Parser;
import mortytheplatypus.Problem2.Parsers.PythonParser;

public class Editor {
    public static Editor instance;
    Language language;
    Font font;
    Parser parser;

    public Editor() {
        instance = null;
    }

    public void setEditor(String language) {
        if (language.equalsIgnoreCase("C")) {
            instance.language = new C();
            instance.font = new CourierNew();
            instance.parser = new CParser();
        } else if (language.equalsIgnoreCase("CPP")) {
            instance.language = new CPP();
            instance.font = new Monaco();
            instance.parser = new CPPParser();
        } else if (language.equalsIgnoreCase("PYTHON")) {
            instance.language = new Python();
            instance.font = new Consolas();
            instance.parser = new PythonParser();
        }
    }

    public Editor getInstance() {
        return instance;
    }

    @Override
    public String toString() {
        if (instance == null) {
            return "Editor not instantiated yet.";
        }
        return "Editor details\n\t" +
                "Language: " + this.language + "\n\t" +
                "  Parser: " + this.parser + "\n\t" +
                "    Font: " + this.font + "\n\t";
    }
}
