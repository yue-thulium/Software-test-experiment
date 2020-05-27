/**
 * Created on 2020/5/27.
 *
 * 语句覆盖与判定覆盖
 *
 * 1语句覆盖
 *
 * 使所有的判断语句都能执行一次的条件案例，例如当判断语句事组合语句的时候，并且用or连接，只满足一个案例即可
 *
 *
 *
 * 2判定覆盖（分支覆盖）
 *
 *  针对判断语句，在设定案例的时候，要设定True和False的两种案例；与语句覆盖不同的是增加了False的情况
 *
 * @author Yue Wu
 */
public class ExperimentOne {

    /**
     * 投保业务逻辑代码
     *
     * @param ifHealth 是否健康 true：健康  false：非健康
     * @param ifJoin  是否参加医疗保险的  true：参加过  false: 未参加过
     * @param age 年龄
     * @param satisfactionPolicy 是否适用商业健康保险税收优惠政策 true: 适用 false:不适用
     * @param sex 性别
     * @return
     */
    public String typeOfInsurance(boolean ifHealth, boolean ifJoin, int age, boolean satisfactionPolicy, String sex) {

        String result = null;

        if (("男".equals(sex) && age >= 16 && age<=59 || "女".equals(sex) && age >= 16 && age<=54) && satisfactionPolicy) {
            if (ifHealth || ifJoin) {
                result = "可选 A款、B1款或B2款。\n该项对应流程图中的C分支\n";
            } else {
                result = "可选C款。\n该项对应流程图中的E分支\n";
            }
        } else {
            result = "不能作为本合同的参保人。\n该项对应流程图中的D分支\n";
        }
        return result;
    }

    /**
     * 语句覆盖
     * 不考虑false的情况
     * TestCase1 ：性别及年龄符合即可，被保人为健康体  或  有医疗保险
     * TestCase2 ：性别及年龄符合即可，被保人为非健康体  或  无医疗保险
     */
    public void statementOverride(){
        System.out.println("被保人为男性时：");
        System.out.println(typeOfInsurance(true,true,30,true,"男"));
        System.out.println(typeOfInsurance(false,false,30,true,"男"));
        System.out.println("被保人为女性时：");
        System.out.println(typeOfInsurance(true,true,30,true,"女"));
        System.out.println(typeOfInsurance(false,false,30,true,"女"));
    }

    /**
     * 判定覆盖（分支覆盖）
     * 考虑false的情况
     * TestCase1 ：性别及年龄符合即可，被保人为健康体  或  有医疗保险
     * TestCase2 ：性别及年龄符合即可，被保人为非健康体  或  无医疗保险
     * TestCase3：被保人不满足年龄及要求
     */
    public void decisionCoverage() {
        System.out.println("被保人为男性时：");
        System.out.println(typeOfInsurance(true,true,11,true,"男"));
        System.out.println(typeOfInsurance(true,true,30,true,"男"));
        System.out.println(typeOfInsurance(false,false,30,true,"男"));
        System.out.println("被保人为女性时：");
        System.out.println(typeOfInsurance(true,true,11,true,"女"));
        System.out.println(typeOfInsurance(true,true,30,true,"女"));
        System.out.println(typeOfInsurance(false,false,30,true,"女"));
    }
}
