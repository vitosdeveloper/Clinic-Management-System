package org.vitosdeveloper.clinic_management.application.usecases.user.contracts;

public interface ILoginUser {
    boolean execute(String email, String password);
}
