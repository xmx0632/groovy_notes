

def mon = new Weekday('Mon')
def fri = new Weekday('Fri')
def worklog = ''
for (day in mon..fri){
    worklog += day.toString() + ' '
}
assert worklog == 'Mon Tue Wed Thu Fri '