package iodatastream.bank;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class BankAccountManager {

    public void saveAccount(BankAccount bankAccount, Path folderName) {
        Path path = folderName.resolve(bankAccount.getAccountNumber() + ".dat");
        try (DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(Files.newOutputStream(path)))) {
            dos.writeUTF(bankAccount.getAccountNumber());
            dos.writeUTF(bankAccount.getOwner());
            dos.writeDouble(bankAccount.getBalance());
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not write file.", ioe);
        }
    }

    public BankAccount loadAccount(InputStream is) {
        try (DataInputStream dis = new DataInputStream(new BufferedInputStream(is))) {
            return new BankAccount(dis.readUTF(), dis.readUTF(), dis.readDouble());
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not write file.", ioe);
        }
    }
}
