package kr.arch.deal.account.domain.activity;

import java.time.LocalDateTime;

import kr.arch.deal.account.domain.account.vo.Money;
import kr.arch.deal.account.domain.account.Account;
import kr.arch.deal.account.domain.account.vo.AccountId;
import kr.arch.deal.account.domain.activity.vo.ActivityId;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Value;

/**
 * A money transfer activity between {@link Account}s.
 */
@Getter
@Value
@RequiredArgsConstructor
public class Activity {

    ActivityId id;

    /**
     * 소유 계정 id
     */
    @NonNull
    AccountId ownerAccountId;

    /**
     * 인출 계정 id
     */
    @NonNull
    AccountId sourceAccountId;

    /**
     * 송금된 계정 id
     */
    @NonNull
    AccountId targetAccountId;

    @NonNull
    LocalDateTime timestamp;

    /**
     * 돈
     */
    @NonNull
    Money money;

    public Activity(
            @NonNull AccountId ownerAccountId,
            @NonNull AccountId sourceAccountId,
            @NonNull AccountId targetAccountId,
            @NonNull LocalDateTime timestamp,
            @NonNull Money money) {
        this.id = null;
        this.ownerAccountId = ownerAccountId;
        this.sourceAccountId = sourceAccountId;
        this.targetAccountId = targetAccountId;
        this.timestamp = timestamp;
        this.money = money;
    }
}
