package com.poli.virtualwallet.collection;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

@Data
@Document(collection = "transactions")
public class Transactions {
    @Id
    private String id;
    private String source;
    private String receiver;
    private Double amount;
    private String date;

    @Override
    public String toString() {
        return "Transacciones{" +
                "id='" + id + '\'' +
                ", source='" + source + '\'' +
                ", receiver='" + receiver + '\'' +
                ", amount=" + amount +
                ", date='" + date + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transactions that = (Transactions) o;
        return id.equals(that.id) && source.equals(that.source) && receiver.equals(that.receiver) && amount.equals(that.amount) && date.equals(that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, source, receiver, amount, date);
    }
}
