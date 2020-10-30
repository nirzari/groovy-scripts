import hudson.model.*
import jenkins.model.Jenkins


def jobName = '<folder-name>/<job-name>'

def job = Jenkins.instance.getItemByFullName(jobName)
// Make a list of jobs to rebuild. type: int e.g. [2210, 2211]
def myList = [<build-number-1>, <build-number-2>]
for(int item : myList) {
  def my_job = job.getBuildByNumber(item)
  def actions = my_job.getActions(ParametersAction)
  println(my_job)
  job.scheduleBuild2(0, actions.toArray(new ParametersAction[actions.size()]))
  println("\n")
}
