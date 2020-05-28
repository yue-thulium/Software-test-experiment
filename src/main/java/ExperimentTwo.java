/**
 * Created on 2020/5/28.
 *
 * 3条件覆盖
 * 针对判断语句里面案例的取值都要去一次，不考虑条件的取值
 *
 * 4条件组合覆盖
 * 判定中条件的各种组合都至少被执行一次
 *
 * @author Yue Wu
 */
public class ExperimentTwo {

    /**
     * 内部转账逻辑代码片段
     * @param transferMoney 转账金额
     * @param confirmationMethod 确认方式
     */
    public void internalTransfer(double transferMoney, int confirmationMethod){
        if (transferMoney > 1000000) {
            System.out.println("调用\"内部转账发起复核\"\n调用\"内部转账发起授权\"");

            if (confirmationMethod == 1) {
                System.out.println("抛出异常\"确认方式不符合业务流程\"");
            } else if (confirmationMethod == 2) {
                System.out.println("调用\"内部转账接收经办\"\n调用\"内部转账接收授权\"");
                System.out.println("确认接收");
            } else if (confirmationMethod == 3) {
                System.out.println("调用\"内部转账接收经办\"\n调用\"内部转账接收复核\"\n调用\"内部转账接收授权\"");
                System.out.println("确认接收");
            } else {
                System.out.println("抛出异常\"确认方式不符合业务流程\"");
            }
        } else if (0 < transferMoney && transferMoney <= 1000000) {
            if (confirmationMethod == 1) {
                System.out.println("调用\"内部转账接收确认\"");
            } else if (confirmationMethod == 2) {
                System.out.println("调用\"内部转账接收经办\"\n调用\"内部转账接收确认\"");
                System.out.println("确认接收");
            } else if (confirmationMethod == 3) {
                System.out.println("调用\"内部转账接收经办\"\n调用\"内部转账接收复核\"\n调用\"内部转账接收确认\"");
                System.out.println("确认接收");
            } else {
                System.out.println("抛出异常\"确认方式不符合业务流程\"");
            }
        } else if (transferMoney < 0) {
            System.out.println("抛出异常\"输人金额有误,请重新输入\"");
        }
        System.out.println("\n--------这是分割线--------\n");
    }

    /**
     * 条件覆盖
     */
    public void conditionalCoverage() {
        System.out.println("CASE:1{覆盖条件：转账金额>100W}\n");
        internalTransfer(1200000,1);
        System.out.println("CASE:2{覆盖条件：转账金额<=100W}\n");
        internalTransfer(90,2);
        internalTransfer(-10,3);
        System.out.println("CASE:3{覆盖条件：确认方式 == 1}\n");
        internalTransfer(9,1);
        System.out.println("CASE:4{覆盖条件：确认方式 == 2}\n");
        internalTransfer(9,2);
        System.out.println("CASE:5{覆盖条件：确认方式 == 3}\n");
        internalTransfer(9,3);
        System.out.println("CASE:6{覆盖条件：确认方式 <> 1 2 3}\n");
        internalTransfer(9,0);
    }

    /**
     * 条件组合覆盖
     *
     * 对于判定1:
     * ①条件转账金额> 100W取真为T1
     * ②条件转账金额< =100W取假为F1
     * 对于判定2:
     * ①条件确认方式”== 1取真为T2
     * ②条件"确认方式"==2取真为T3
     * ③条件*确认方式"==3取真为T4
     * ④条件T2、T3和T4都不成立，取假为F2
     * 对于判定3:
     * ①条件"确认方式”==2取真为T5
     * ②条件"确认方式”==3取真为T6
     * ③条件T5和T6都不成立，取假为F3
     *
     */
    public void conditionalCombinationCoverage() {
        System.out.println("CASE1:覆盖T1+T5：转账金额>100W & \"确认方式\" == 2");
        internalTransfer(1200000,2);
        System.out.println("CASE2:覆盖T1+T6：转账金额>100W & \"确认方式\" == 3");
        internalTransfer(1200000,3);
        System.out.println("CASE3:覆盖T1+F3：转账金额>100W & \"确认方式\" != 2 or 3");
        internalTransfer(1200000,1);
        internalTransfer(1200000,4);
        System.out.println("CASE4:覆盖F1+T2：0 < 转账金额 <= 100W & \"确认方式\" == 1");
        internalTransfer(250,1);
        System.out.println("CASE5:覆盖F1+T3：0 < 转账金额 <= 100W & \"确认方式\" == 2");
        internalTransfer(250,2);
        System.out.println("CASE6:覆盖F1+T4：0 < 转账金额 <= 100W & \"确认方式\" == 3");
        internalTransfer(250,3);
        System.out.println("CASE7:覆盖F1+F2：0 < 转账金额 <= 100W & \"确认方式\" != 1 or 2 or 3");
        internalTransfer(250,0);
    }
}
