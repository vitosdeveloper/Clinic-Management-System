package org.vitosdeveloper.clinic_management.application.security;

public interface IPasswordHasher {
    String hash(String password);
}
