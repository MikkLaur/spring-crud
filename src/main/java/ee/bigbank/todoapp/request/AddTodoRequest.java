package ee.bigbank.todoapp.request;

public class AddTodoRequest {

    private String summary;

    public AddTodoRequest() {
    }

    public AddTodoRequest(String summary) {
        this.summary = summary;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }
}
