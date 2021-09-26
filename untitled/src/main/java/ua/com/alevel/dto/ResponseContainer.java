package ua.com.alevel.demo.dto;

public class ResponseContainer<DATA> {
    private DATA data;

    public ResponseContainer(DATA data) {
        this.data = data;
    }

    public DATA getData() {
        return data;
    }

    public void setData(DATA data) {
        this.data = data;
    }
}
