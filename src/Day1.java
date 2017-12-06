import java.math.BigInteger;

import static java.lang.Character.valueOf;

public class Day1 {

    public static void main(String[] args) {
        String s = "9384274494683632359351641411374573466273164687337536769779487433749179185568" +
                "461296233353611992672753778126935276769885424719553291616136172298883156626254151" +
                "278852582397949697874462178536295341822137377563322815527592267791213115418635363" +
                "174876132196234374887626324931371241841242873783493835919238421879116421481543826" +
                "222278152238576762132577763214642569545298668935216911493462229629786978273548147" +
                "171384321525952959196377728493632872618291183256888417779495124837828187298244786" +
                "175872713299271766246696631257484453347125176233373232245382158656142179687576388" +
                "951175953419286858673221138553912229576523123114871637487978775855777483921896568" +
                "333282333137175739746234262744256254149233843517254613981476355147487975859685936" +
                "527161737644929119345127273149762325158784595946931447738173246311763677997888425" +
                "452294562823751136515271874725143582623717324394587398371298523368386595426714148" +
                "717735345237657249712685895921433468949182235146698174393928288313985355769799485" +
                "511749423552935992391624424575278333625476148888355716967628454862834463357834291" +
                "788479677576561681171516128495737923155533438413156639155128831349894646317546536" +
                "886319328573512622325789672115171618195548534941184939233914166432349321992879287" +
                "349932819135919518955561456615989137221875483561599493342981595678961836562435436" +
                "285673764213941758954489582656271121429555455368545289416981624961261963953364918" +
                "377483776322142975937971552271642224933926326665557787586927667898255947116988278" +
                "131974381388514274833852552695679713424836536348449273149415872522111522749448188" +
                "993159814183411853994579147867385867619467777654943169814287928966652552129439822" +
                "741856512265955664872454951159255617513136142717471774698224566543617595742753244" +
                "142364438589729356939483387466363477224283477843889679221229344974441624448489853" +
                "764111425798141258155246636844914711222931548722647298953744242682551562166463942" +
                "694715631497895981643174194294826868561578586851326262619731272665397711381459745" +
                "281218196515155917877694663186732599688912878149242688741584822831861748845817871" +
                "681621697944472377688658368145698614861456518138376989688166921187224726942589996" +
                "534179549171859786241718727295379";

        int result1 = calculate(s);

        int result2 = calculateAgain(s);

        System.out.println(result2);
    }

    private static int calculate(String s) {
        int result = 0;

        for (int i = 0; i < s.length()-1; i++) {
            if (valueOf(s.charAt(i))-48 == valueOf(s.charAt(i+1))-48) {
                result += valueOf(s.charAt(i))-48;
            }
        }

        result += 9;
        return result;
    }

    private static int calculateAgain(String s) {
        int result = 0;

        for(int i = 0; i < s.length(); i++) {
            int one = Character.getNumericValue(s.charAt(i));
            int two = Character.getNumericValue(s.charAt((i+s.length()/2)%s.length()));
            if(one == two) {
                result += one;
            }
        }

        return result;
    }
}