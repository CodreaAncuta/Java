package model.report;
import model.User;

public interface Report {

	boolean generateReport(User u, String dest);
}
