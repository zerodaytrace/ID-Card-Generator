package com.zerodaytrace;

import java.time.LocalDate;

public class IDCardGenerator {
    static class IDCard implements Comparable<IDCard> {
        private static final String TITLE = "ID CARD";
        private static final int LABEL_WIDTH = 11;
        private static final int MIN_INTERIOR_WIDTH = 30;

        private String firstName;
        private String lastName;
        private String idNumber;
        private LocalDate dateOfBirth;
        private String role;
        private String gender;

        public IDCard(String firstName, String lastName, String idNumber, String dateOfBirth, String role, String gender) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.idNumber = idNumber;
            this.dateOfBirth = LocalDate.parse(dateOfBirth);
            this.role = role;
            this.gender = gender;
        }


        public String getFirstName() { return firstName; }
        public String getLastName() { return lastName; }
        public String getIdNumber() { return idNumber; }
        public LocalDate getDateOfBirth() { return dateOfBirth; }
        public String getRole() { return role; }
        public String getGender() { return gender; }


        @Override
        public String toString() {
            String[][] fields = {
                    {"Name:", firstName + " " + lastName},
                    {"ID Number:", idNumber},
                    {"DOB:", dateOfBirth.toString()},
                    {"Role:", role},
                    {"Gender:", gender}
            };

            int valueWidth = MIN_INTERIOR_WIDTH - LABEL_WIDTH - 2;
            for (String[] field : fields) {
                valueWidth = Math.max(valueWidth, field[1].length());
            }
            int interiorWidth = LABEL_WIDTH + valueWidth + 2;
            String horizontalRule = "─".repeat(interiorWidth);
            String rowFormat = "│ %-" + LABEL_WIDTH + "s%-" + valueWidth + "s │\n";

            StringBuilder card = new StringBuilder();
            card.append('┌').append(horizontalRule).append("┐\n");
            card.append('│').append(center(TITLE, interiorWidth)).append("│\n");
            card.append('├').append(horizontalRule).append("┤\n");
            for (String[] field : fields) {
                card.append(String.format(rowFormat, field[0], field[1]));
            }
            card.append('└').append(horizontalRule).append('┘');
            return card.toString();
        }

        private static String center(String text, int width) {
            int leftPadding = (width - text.length()) / 2;
            return " ".repeat(leftPadding) + text + " ".repeat(width - text.length() - leftPadding);
        }

        @Override
        public int compareTo(IDCard other) {
            return this.idNumber.compareTo(other.idNumber);
        }
    }
}
