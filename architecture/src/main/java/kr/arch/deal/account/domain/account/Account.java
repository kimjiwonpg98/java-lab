package kr.arch.deal.account.domain.account;

import kr.arch.deal.account.domain.account.vo.ActivityWindow;
import kr.arch.deal.account.domain.account.vo.Money;
import kr.arch.deal.account.domain.account.vo.AccountId;
import lombok.Value;

@Value
public class Account {
    AccountId id;
    /* 기준 잔고 (실행 하기 바로 전의 잔고) */
    Money baselineBalance;
    /* 활동창 */
    ActivityWindow activityWindow;

    public Money calculateBalance() {
        return Money.add(this.baselineBalance, this.activityWindow.calculateBalance(this.id));
    }
}
