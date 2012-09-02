package com.bullx.heartbeat;

public enum CommandType {

    GETCONFIG(1),
    SETCONFIG(2),
    RESEND(3),
    GETNEWDATA(4),
    BEGIN(5),
    END(6);
    
    

    private final int code;

    private CommandType(int code) {
        this.code = code;
    }

    /**
     * @return the code
     */
    public int getCode() {
        return code;
    }
}
