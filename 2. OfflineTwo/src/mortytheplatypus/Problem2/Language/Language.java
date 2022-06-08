package mortytheplatypus.Problem2.Language;

public abstract class Language {
    private String language;

    protected Language(String language) {
        this.language = language;
    }

    @Override
    public String toString() {
        return language;
    }
}
