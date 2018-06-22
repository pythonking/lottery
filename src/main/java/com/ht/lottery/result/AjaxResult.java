package com.ht.lottery.result;

public class AjaxResult {
    /**
     * 200:成功,500返回数据异常,401表示参数错误
     */
    public static final String STATE_SUCCESS = "200";
    public static final String STATE_ERROR = "500";
    public static final String STATE_PARAM_ERROR = "401";
    public static final String MSG_SUCCESS = "SUCCESS";

    public static AjaxResult success() {
        AjaxResult ajaxResult = new AjaxResult();
        ajaxResult.setState(STATE_SUCCESS);
        ajaxResult.setMessage(MSG_SUCCESS);
        return ajaxResult;
    }

    public static AjaxResult successWithData(Object data) {
        AjaxResult ajaxResult = new AjaxResult();
        ajaxResult.setState(STATE_SUCCESS);
        ajaxResult.setMessage(MSG_SUCCESS);
        ajaxResult.setData(data);
        return ajaxResult;
    }

    public static AjaxResult successWithData(String message, Object data) {
        AjaxResult ajaxResult = new AjaxResult();
        ajaxResult.setState(STATE_SUCCESS);
        ajaxResult.setData(data);
        ajaxResult.setMessage(message);
        return ajaxResult;
    }

    public static AjaxResult error(String message) {
        AjaxResult ajaxResult = new AjaxResult();
        ajaxResult.setState(STATE_ERROR);
        ajaxResult.setMessage(message);
        return ajaxResult;
    }

    public static AjaxResult error(String state, String message) {
        AjaxResult ajaxResult = new AjaxResult();
        ajaxResult.setState(state);
        ajaxResult.setMessage(message);
        return ajaxResult;
    }

    private String state;
    private String message;
    private Object data;

    public AjaxResult() {
    }

    public AjaxResult(String state) {
        this.state = state;
    }

    public AjaxResult(String state, Object data) {
        this.state = state;
        this.data = data;
    }

    public AjaxResult(String state, String message) {
        this.state = state;
        this.message = message;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "AjaxResult{" +
                "state='" + state + '\'' +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
