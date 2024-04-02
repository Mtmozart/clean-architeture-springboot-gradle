package br.com.curso.core.domain;

import br.com.curso.core.exception.TransactionPinException;
import br.com.curso.core.exception.enums.ErrorCodeEnum;

import java.time.LocalDateTime;
import java.util.Objects;

import static br.com.curso.core.exception.enums.ErrorCodeEnum.PIN0001;

public class TransactionPin {

    private Long id;

    private String pin;
    private Integer attempt;
    private Boolean blocker;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public TransactionPin(Long id, String pin, Integer attempt, Boolean blocker, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;

        this.pin = pin;
        this.attempt = attempt;
        this.blocker = blocker;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public TransactionPin(String pin) throws TransactionPinException {
        setPin(pin);
        this.attempt = 3;
        this.blocker = false;
        this.createdAt = LocalDateTime.now();
    }
   public TransactionPin() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) throws TransactionPinException {
       pinIsValid(pin);
        this.pin = pin;
    }

    private void pinIsValid(String pin) throws TransactionPinException {
        if(pin.length() != 8){
        throw new TransactionPinException(ErrorCodeEnum.TRP0001.getMessage(), ErrorCodeEnum.TRP0001.getCode());
        }
    }

    public Integer getAttempt() {
        return attempt;
    }

    public void setAttempt() {
        if(this.attempt == 1) {
            this.blocker = true;
            this.attempt = 0;
        }else{
            this.attempt = this.attempt -1;
        }

    }

    public Boolean getBlocker() {
        return blocker;
    }

    public void setBlocker(Boolean blocker) {
        this.blocker = blocker;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }


    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public void restaureAttempt(){
        this.attempt = 3;
    }


    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;

        TransactionPin that = (TransactionPin) object;

        if (!Objects.equals(id, that.id)) return false;
        if (!pin.equals(that.pin)) return false;
        if (!attempt.equals(that.attempt)) return false;
        if (!blocker.equals(that.blocker)) return false;
        if (!createdAt.equals(that.createdAt)) return false;
        return Objects.equals(updatedAt, that.updatedAt);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + pin.hashCode();
        result = 31 * result + attempt.hashCode();
        result = 31 * result + blocker.hashCode();
        result = 31 * result + createdAt.hashCode();
        result = 31 * result + (updatedAt != null ? updatedAt.hashCode() : 0);
        return result;
    }
}
