# testLocalDate1900
test LocalDate 1900 insert into mysql


## problem
while the date is 1900-MM-dd, it will be minused one day after insert into mysql.

## reason
service's time zone is GMT-8, and china date will minus 1 hour if we use this to caculate date by SimpleDateFormat for 1900.
Code : ClientPreparedQueryBindings ->

```    
@Override
public void setDate(int parameterIndex, Date x, Calendar cal) {
    if (x == null) {
        setNull(parameterIndex);
    } else {
        this.ddf = TimeUtil.getSimpleDateFormat(this.ddf, "''yyyy-MM-dd''", cal, cal != null ? null : this.session.getServerSession().getDefaultTimeZone());
        setValue(parameterIndex, this.ddf.format(x), MysqlType.DATE);
    }
}
```
## solution
1. change the date field from date/datetime to varchar;
2. change service's time zone;
3. set time zone in the datasource url: such as add serverTimezone=Asia/Shanghai
