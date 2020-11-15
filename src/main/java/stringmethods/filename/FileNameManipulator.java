package stringmethods.filename;

public class FileNameManipulator {

   public char findLastCharacter(String str) {

       if (str == null || str.equals("")) {
           throw new IllegalArgumentException("Empty string!");
       }

       str = str.trim();

       return str.charAt(str.length() - 1);
   }

   public String findFileExtension(String fileName) {

       if (fileName == null || fileName.equals("") || fileName.equals(".") || fileName.length() < 3 || fileName.startsWith(".") || fileName.endsWith(".") || !fileName.contains(".") || fileName.isEmpty() || fileName.isBlank()) {
           throw new IllegalArgumentException("Invalid file name!");
       }

       int dot = fileName.indexOf(".");

       if (fileName.indexOf(".",dot + 1) > 0) {
           throw new IllegalArgumentException("Invalid file name!");
       }

       return fileName.substring(dot);
   }

   public boolean identifyFilesByExtension (String ext, String fileName) {
       if (ext == null || ext.equals("") || fileName == null || fileName.equals("") || fileName.startsWith(".") || fileName.endsWith(".") || ext.contains(".") || !fileName.contains(".") || fileName.length() < 3 || ext.isEmpty() || ext.isBlank() || fileName.isEmpty() || fileName.isBlank()) {
           throw new IllegalArgumentException("Invalid argument!");
       }

       ext = ext.trim();
       fileName = fileName.trim();
       int dot = fileName.indexOf(".");
       String extension = fileName.substring(dot + 1);
       return ext.equals(extension);
   }

   public boolean compareFilesByName(String searchedFileName, String actualFileName) {
       if (searchedFileName == null || searchedFileName.equals("") || !searchedFileName.contains(".") || searchedFileName.length() < 3 || searchedFileName.startsWith(".") || searchedFileName.endsWith(".") || actualFileName == null || actualFileName.equals("") || actualFileName.length() < 3 || !actualFileName.contains(".") || searchedFileName.isEmpty() || searchedFileName.isBlank() || actualFileName.isEmpty() || actualFileName.isBlank()) {
           throw new IllegalArgumentException("Invalid argument!");
       }

       return searchedFileName.trim().toLowerCase().equals(actualFileName.trim().toLowerCase());
   }

   public String changeExtensionToLowerCase(String fileName) {
       if (fileName.equals(".") || fileName.length() < 3 || fileName.startsWith(".") || fileName.endsWith(".")) {
           throw new IllegalArgumentException("Invalid argument!");
       }
       if (fileName == null || fileName.equals("") || fileName.isEmpty() || fileName.isBlank()) {
           throw new IllegalArgumentException("Empty string!");
       }

       fileName = fileName.trim();
       int dot = fileName.indexOf(".");
       String name = fileName.substring(0, dot);
       String extension = fileName.substring(dot + 1);
       return name + "." + extension.toLowerCase();
   }

   public String replaceStringPart (String fileName, String present, String target) {
       if (fileName == null || fileName.isEmpty() || fileName.isBlank() || fileName.equals("")) {
           throw new IllegalArgumentException("Empty string!");
       }

       if (fileName.contains(present)) {
           fileName = fileName.replace(present, target);
       }
       return fileName;
   }
}
