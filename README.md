# testLocalDate1900
test LocalDate 1900 insert into mysql


# problem
while the date is 1900-MM-dd, it will be minused one day after insert into mysql.

# reason
service's time zone is GMT-8, and china date will minus 1 hour if we use this to caculate date by SimpleDateFormat for 1900.

# solution
1. change the date field from date/datetime to varchar;
2. change service's time zone;
3. set time zone in the datasource url: such as add serverTimezone=Asia/Shanghai
