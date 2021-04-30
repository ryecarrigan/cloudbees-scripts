// Configure the start and end dates.
def start  = new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime();
def finish = new GregorianCalendar(2021, Calendar.JANUARY, 1).getTime();

// Count all builds between the dates.
def builds = Jenkins.instance.getView('all').getBuilds()
def filter = builds.findAll { build ->
  build.time.after(start) && build.time.before(finish)
}

return filter.size()
