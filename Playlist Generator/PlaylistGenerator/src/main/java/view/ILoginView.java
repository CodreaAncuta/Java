package view;


interface ILoginDataProvider {

    String getUsername();
    String getPassword();
    String getOption();

}

interface IViewProvider {

    void showAdminView();
    void showRegularView();
    void showErrorMessage(String message);
}

public interface ILoginView extends ILoginDataProvider, IViewProvider {
}
