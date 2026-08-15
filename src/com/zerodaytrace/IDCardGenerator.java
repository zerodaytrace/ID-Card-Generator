package com.zerodaytrace;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class IDCardGenerator {
    static class IDCard implements Comparable<IDCard> {
        private String firstName;
        private String lastName;
        private String idNumber;
        private LocalDate dateOfBirth;
        private String role;

        public IDCard(String firstName, String lastName, String idNumber, String dateOfBirth, String role) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.idNumber = idNumber;
            this.dateOfBirth = LocalDate.parse(dateOfBirth, DateTimeFormatter.ISO_LOCAL_DATE);
            this.role = role;
        }


        public String getFirstName() { return firstName; }
        public String getLastName() { return lastName; }
        public String getIdNumber() { return idNumber; }
        public LocalDate getDateOfBirth() { return dateOfBirth; }
        public String getRole() { return role; }

        @Override
        public String toString() {
            return String.format("┌──────────────────────────────┐\n" +
                    "│         ID CARD              │\n" +
                    "├──────────────────────────────┤\n" +
                    "│ Name:      %-16s │\n" +
                    "│ ID Number: %-16s │\n" +
                    "│ DOB:       %-16s │\n" +
                    "│ Role:      %-16s │\n" +
                    "└──────────────────────────────┘",
                    firstName + " " + lastName,
                    idNumber,
                    dateOfBirth.toString(),
                    role);
        }

        @Override
        public int compareTo(IDCard other) {
            return this.idNumber.compareTo(other.idNumber);
        }
    }
}
