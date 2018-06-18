package warsztaty.java.ailleronLab.model;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.ArrayList;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class RestResponse {

    private ArrayList<String> messages;
    private Result result;
    private String sayHello;

    public ArrayList<String> getMessages() {
        return messages;
    }

    public Result getResult() {
        return result;
    }

    public String getSayHello() {
        return sayHello;
    }

    public void setMessages(ArrayList<String> messages) {
        this.messages = messages;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public void setSayHello(String sayHello) {
        this.sayHello = sayHello;
    }
}
