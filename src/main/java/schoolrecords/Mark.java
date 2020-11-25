package schoolrecords;

public class Mark {

    private MarkType markType;
    private Subject subject;
    private Tutor tutor;

    public Mark(MarkType markType, Subject subject, Tutor tutor) {

        if (subject == null || tutor == null) {
            throw new NullPointerException("Both subject and tutor must be provided!");
        }

        this.markType = markType;
        this.subject = subject;
        this.tutor = tutor;
    }

    public Mark(String markType, Subject subject, Tutor tutor) {

        if (subject == null || tutor == null) {
            throw new NullPointerException("Both subject and tutor must be provided!");
        }

        this.markType = getMarkType(markType);
        this.subject = subject;
        this.tutor = tutor;
    }

    public MarkType getMarkType() {
        return markType;
    }

    public Subject getSubject() {
        return subject;
    }

    public Tutor getTutor() {
        return tutor;
    }

    @Override
    public String toString() {
        return markType.getDescription() + "(" + markType.getValue() + ")";
    }

    private MarkType getMarkType(String str) {
        for (MarkType m : MarkType.values()) {
            if (str.equals(m.getDescription())) {
                return MarkType.values()[m.ordinal()];
            }
        }
        return null;
    }
}
