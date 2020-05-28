import org.junit.Test;

/**
 * Created on 2020/5/28.
 *
 * 修正条件/判定覆盖
 * 程序中每个判定至少有一次为真值，有一次为假值,使得程序中每个分支至少执行一次
 *
 * @author Yue Wu
 */
public class ExperimentThree {

    /**
     * 信用卡还款逻辑代码（简化测试适用代码，并非为实际业务代码）
     * @param cardId 银行卡号是否有效 true : 有效 false : 无效
     * @param name 姓名是否有效 true : 有效 false : 无效
     * @param balance 余额
     * @param payBack 待还
     * @param repaymentMethod 还款方式：全额 or分期
     */
    public void creditCardPayment(boolean cardId, boolean name , double balance , double payBack, String repaymentMethod) {
        if (cardId && name && balance > 0) {
            if ("全额还款".equals(repaymentMethod) || "分期还款".equals(repaymentMethod)) {
                if (balance >= payBack) {
                    System.out.println("打印\"还款成功\"");
                } else {
                    System.out.println("打印\"余额不足\"");
                }
            } else {
                System.out.println("打印\"返回\"");
            }
        } else {
            System.out.println("打印\"卡号错误或卡号姓名不一致或余额<=0\"");
        }
        System.out.println("\n-------这是分割线-------\n");
    }

    /**
     * 修正条件/判定覆盖
     */
    @Test
    public void decisionCoverage() {
        System.out.println("CASE1:{还款成功：全额还款}");
        creditCardPayment(true,true,100,50,"全额还款");
        System.out.println("CASE2:{还款成功：分期还款}");
        creditCardPayment(true,true,100,50,"分期还款");
        System.out.println("CASE3:{还款失败：不选择全额还款、分期还款}");
        creditCardPayment(true,true,100,50,"");
        System.out.println("CASE4:{还款失败：银行卡有效、姓名无效、余额>0}");
        creditCardPayment(true,false,100,50,"全额还款");
        System.out.println("CASE5:{还款失败：银行卡无效、姓名有效、余额>0}");
        creditCardPayment(false,true,100,50,"全额还款");
        System.out.println("CASE6:{还款失败：银行卡有效、姓名有效、余额<=0}");
        creditCardPayment(true,true,-1,50,"全额还款");
        System.out.println("CASE7:{还款失败：全额还款}");
        creditCardPayment(true,true,100,150,"全额还款");
        System.out.println("CASE8:{还款失败：分期还款}");
        creditCardPayment(true,true,100,150,"分期还款");
    }
}
