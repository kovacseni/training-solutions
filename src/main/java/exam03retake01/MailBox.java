package exam03retake01;

import java.util.ArrayList;
import java.util.List;

public class MailBox {

    private List<Mail> mails = new ArrayList<>();

    public void addMail(Mail mail) {
        mails.add(mail);
    }

    public List<Mail> getMails() {
        return new ArrayList<>(mails);
    }

    public List<Mail> findByCriteria(String criteria) {
        if (criteria.startsWith("from:")) {
            return foundMailsWithFrom(criteria);
        } else if (criteria.startsWith("to:")) {
            return foundMailsWithTo(criteria);
        } else {
            return foundMailsWithSubjectOrMessage(criteria);
        }
    }

    private List<Mail> foundMailsWithFrom(String criteria) {
        int index = criteria.indexOf(":") + 1;
        String from = criteria.substring(0, index);
        String searched = criteria.substring(index);

        List<Mail> found = new ArrayList<>();
        for (Mail m : mails) {
            if (m.getFrom().getName().equals(searched) || m.getFrom().getEmail().equals(searched)) {
                found.add(m);
            }
        }
        return found;
    }

    private List<Mail> foundMailsWithTo(String criteria) {
        int index = criteria.indexOf(":") + 1;
        String to = criteria.substring(0, index);
        String searched = criteria.substring(index);

        List<Mail> found = new ArrayList<>();
        for (Mail m : mails) {
            searchAndAddToList(searched, m, found);
        }
        return found;
    }

    private void searchAndAddToList(String searched, Mail m, List<Mail> found) {
        for (Contact c : m.getTo()) {
            if (c.getName().equals(searched) || c.getEmail().equals(searched)) {
                found.add(m);
            }
        }
    }

    private List<Mail> foundMailsWithSubjectOrMessage(String criteria) {
        List<Mail> found = new ArrayList<>();
        for (Mail m : mails) {
            if (m.getSubject().contains(criteria) || m.getMessage().contains(criteria)) {
                found.add(m);
            }
        }
        return found;
    }
}
