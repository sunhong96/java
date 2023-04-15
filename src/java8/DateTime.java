package java8;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class DateTime {
    public static void main(String[] args) {
        Calendar birthday = new GregorianCalendar(1996,12,7);
        //이건 month가 0부터 1월부터 시작해서 출력 오류가 남

        Date date = new Date();
        long time = date.getTime();
        System.out.println(time); // 기계용 시간

        System.out.println("--------------------------");

        Instant instant = Instant.now();
        System.out.println(instant); // 기준시 UTC, GMT 로 출력함

        System.out.println("--------------------------");

        ZoneId zone = ZoneId.systemDefault();
        System.out.println(zone); //위치
        ZonedDateTime zonedDateTime = instant.atZone(zone);
        System.out.println(zonedDateTime); //위치와 시간

        System.out.println("--------------------------");

        LocalDateTime now = LocalDateTime.now();
        System.out.println(now); // 그 서버의 시스템 기본 시간이 찍힘 주의해야함
        LocalDateTime sunbirthday = LocalDateTime.of(1996, Month.DECEMBER, 7, 0, 0, 0);
        System.out.println(sunbirthday);
        //특정한시간대에 해당하는 시간을만들수도 있음

        System.out.println("--------------------------");

        ZonedDateTime nowInKorea = ZonedDateTime.now(ZoneId.of("Asia/Seoul"));
        System.out.println(nowInKorea);

        Instant nowInstant = Instant.now();
        ZonedDateTime zonedDateTime1 = nowInstant.atZone(ZoneId.of("Asia/Seoul"));
        System.out.println(zonedDateTime1);

        zonedDateTime1.toInstant(); // 서로 왔다갓다 변경해줄수있음 출력은 같음

        System.out.println("--------------------------");

        LocalDate today = LocalDate.now();
        LocalDate thisYearBirthday = LocalDate.of(2023,Month.DECEMBER,7);

        Period period = Period.between(today, thisYearBirthday);
        System.out.println(period.getDays()); //남은 일수만 계산해줌

        Period until = today.until(thisYearBirthday);
        System.out.println(until.get(ChronoUnit.DAYS)); //남은 일수만을 계산할수있는 다른식

        System.out.println("--------------------------");

        Instant now1 = Instant.now(); //현재시간 저장
        Instant plus = now1.plus(10, ChronoUnit.SECONDS); //현재시간저장한거에 10초를 추가
        Duration between = Duration.between(now1, plus); // 그 둘 사이의 초 비교
        System.out.println(between.getSeconds()); // 기계용 시간비교

        System.out.println("--------------------------");

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        System.out.println(now.format(dateTimeFormatter));
        //날짜를 어떤형식으로 표현할지 직접 커스텀

        System.out.println("--------------------------");

        LocalDate parse = LocalDate.parse("12/07/1996", dateTimeFormatter);
        System.out.println(parse);

        System.out.println("--------------------------");

        Date newDate = Date.from(instant);
        System.out.println(newDate);

        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        LocalDateTime dateTime = gregorianCalendar.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();

        System.out.println("--------------------------");

        ZoneId zoneId = TimeZone.getTimeZone("PST").toZoneId(); //예전 api를 최근 api로 변경
        TimeZone timeZone = TimeZone.getTimeZone(zoneId); //최근 api를 예전껄로변경

    }
}
