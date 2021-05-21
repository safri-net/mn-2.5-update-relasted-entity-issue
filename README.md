# Repository method `updateEntity` won't compile

After upgrading from micronaut 2.4.x to 2.5.x a repository as below does not compile anymore.

```groovy
@JdbcRepository(dialect = Dialect.H2)
interface TestRepo extends CrudRepository<EntityOne,UUID> {
    void updateEntityTwo(@Id UUID id, @NotNull @Valid EntityTwo entityTwo)
}
```

The error is:

```
startup failed:
/home/sf/src/issues/mn-data-extended-repo/src/main/groovy/com/example/TestRepo.groovy: 13: Unable to implement Repository method: TestRepo.updateEntityTwo(UUID id,EntityTwo entityTwo). Cannot find a parameter representing the entity update
 @ line 13, column 5.
       void updateEntityTwo(@Id UUID id, @NotNull @Valid EntityTwo entityTwo)
       ^

1 error
org.gradle.api.tasks.TaskExecutionException: Execution failed for task ':compileGroovy'.
        at org.gradle.api.internal.tasks.execution.ExecuteActionsTaskExecuter.lambda$executeIfValid$1(ExecuteActionsTaskExecuter.java:187)
        at org.gradle.internal.Try$Failure.ifSuccessfulOrElse(Try.java:268)
        at org.gradle.api.internal.tasks.execution.ExecuteActionsTaskExecuter.executeIfValid(ExecuteActionsTaskExecuter.java:185)
        at org.gradle.api.internal.tasks.execution.ExecuteActionsTaskExecuter.execute(ExecuteActionsTaskExecuter.java:173)
        at org.gradle.api.internal.tasks.execution.CleanupStaleOutputsExecuter.execute(CleanupStaleOutputsExecuter.java:109)
        at org.gradle.api.internal.tasks.execution.FinalizePropertiesTaskExecuter.execute(FinalizePropertiesTaskExecuter.java:46)
        at org.gradle.api.internal.tasks.execution.ResolveTaskExecutionModeExecuter.execute(ResolveTaskExecutionModeExecuter.java:51)
        at org.gradle.api.internal.tasks.execution.SkipTaskWithNoActionsExecuter.execute(SkipTaskWithNoActionsExecuter.java:57)
        at org.gradle.api.internal.tasks.execution.SkipOnlyIfTaskExecuter.execute(SkipOnlyIfTaskExecuter.java:56)
        at org.gradle.api.internal.tasks.execution.CatchExceptionTaskExecuter.execute(CatchExceptionTaskExecuter.java:36)
        at org.gradle.api.internal.tasks.execution.EventFiringTaskExecuter$1.executeTask(EventFiringTaskExecuter.java:77)
        at org.gradle.api.internal.tasks.execution.EventFiringTaskExecuter$1.call(EventFiringTaskExecuter.java:55)
        at org.gradle.api.internal.tasks.execution.EventFiringTaskExecuter$1.call(EventFiringTaskExecuter.java:52)
        at org.gradle.internal.operations.DefaultBuildOperationRunner$CallableBuildOperationWorker.execute(DefaultBuildOperationRunner.java:200)
        at org.gradle.internal.operations.DefaultBuildOperationRunner$CallableBuildOperationWorker.execute(DefaultBuildOperationRunner.java:195)
        at org.gradle.internal.operations.DefaultBuildOperationRunner$3.execute(DefaultBuildOperationRunner.java:75)
        at org.gradle.internal.operations.DefaultBuildOperationRunner$3.execute(DefaultBuildOperationRunner.java:68)
        at org.gradle.internal.operations.DefaultBuildOperationRunner.execute(DefaultBuildOperationRunner.java:153)
        at org.gradle.internal.operations.DefaultBuildOperationRunner.execute(DefaultBuildOperationRunner.java:68)
        at org.gradle.internal.operations.DefaultBuildOperationRunner.call(DefaultBuildOperationRunner.java:62)
        at org.gradle.internal.operations.DefaultBuildOperationExecutor.lambda$call$2(DefaultBuildOperationExecutor.java:76)
        at org.gradle.internal.operations.UnmanagedBuildOperationWrapper.callWithUnmanagedSupport(UnmanagedBuildOperationWrapper.java:54)
        at org.gradle.internal.operations.DefaultBuildOperationExecutor.call(DefaultBuildOperationExecutor.java:76)
        at org.gradle.api.internal.tasks.execution.EventFiringTaskExecuter.execute(EventFiringTaskExecuter.java:52)
        at org.gradle.execution.plan.LocalTaskNodeExecutor.execute(LocalTaskNodeExecutor.java:74)
        at org.gradle.execution.taskgraph.DefaultTaskExecutionGraph$InvokeNodeExecutorsAction.execute(DefaultTaskExecutionGraph.java:408)
        at org.gradle.execution.taskgraph.DefaultTaskExecutionGraph$InvokeNodeExecutorsAction.execute(DefaultTaskExecutionGraph.java:395)
        at org.gradle.execution.taskgraph.DefaultTaskExecutionGraph$BuildOperationAwareExecutionAction.execute(DefaultTaskExecutionGraph.java:388)
        at org.gradle.execution.taskgraph.DefaultTaskExecutionGraph$BuildOperationAwareExecutionAction.execute(DefaultTaskExecutionGraph.java:374)
        at org.gradle.execution.plan.DefaultPlanExecutor$ExecutorWorker.lambda$run$0(DefaultPlanExecutor.java:127)
        at org.gradle.execution.plan.DefaultPlanExecutor$ExecutorWorker.execute(DefaultPlanExecutor.java:191)
        at org.gradle.execution.plan.DefaultPlanExecutor$ExecutorWorker.executeNextNode(DefaultPlanExecutor.java:182)
        at org.gradle.execution.plan.DefaultPlanExecutor$ExecutorWorker.run(DefaultPlanExecutor.java:124)
        at org.gradle.internal.concurrent.ExecutorPolicy$CatchAndRecordFailures.onExecute(ExecutorPolicy.java:64)
        at org.gradle.internal.concurrent.ManagedExecutorImpl$1.run(ManagedExecutorImpl.java:48)
        at org.gradle.internal.concurrent.ThreadFactoryImpl$ManagedThreadRunnable.run(ThreadFactoryImpl.java:56)
Caused by: org.gradle.api.internal.tasks.compile.CompilationFailedException: Compilation failed; see the compiler error output for details.
        at org.gradle.api.internal.tasks.compile.ApiGroovyCompiler.execute(ApiGroovyCompiler.java:283)
        at org.gradle.api.internal.tasks.compile.ApiGroovyCompiler.execute(ApiGroovyCompiler.java:67)
        at org.gradle.api.internal.tasks.compile.GroovyCompilerFactory$DaemonSideCompiler.execute(GroovyCompilerFactory.java:98)
        at org.gradle.api.internal.tasks.compile.GroovyCompilerFactory$DaemonSideCompiler.execute(GroovyCompilerFactory.java:77)
        at org.gradle.api.internal.tasks.compile.daemon.AbstractDaemonCompiler$CompilerWorkAction.execute(AbstractDaemonCompiler.java:135)
        at org.gradle.workers.internal.DefaultWorkerServer.execute(DefaultWorkerServer.java:63)
        at org.gradle.workers.internal.AbstractClassLoaderWorker$1.create(AbstractClassLoaderWorker.java:49)
        at org.gradle.workers.internal.AbstractClassLoaderWorker$1.create(AbstractClassLoaderWorker.java:43)
        at org.gradle.internal.classloader.ClassLoaderUtils.executeInClassloader(ClassLoaderUtils.java:97)
        at org.gradle.workers.internal.AbstractClassLoaderWorker.executeInClassLoader(AbstractClassLoaderWorker.java:43)
        at org.gradle.workers.internal.IsolatedClassloaderWorker.run(IsolatedClassloaderWorker.java:49)
        at org.gradle.workers.internal.IsolatedClassloaderWorker.run(IsolatedClassloaderWorker.java:30)
        at org.gradle.workers.internal.WorkerDaemonServer.run(WorkerDaemonServer.java:85)
        at org.gradle.workers.internal.WorkerDaemonServer.run(WorkerDaemonServer.java:55)
        at org.gradle.process.internal.worker.request.WorkerAction$1.call(WorkerAction.java:138)
        at org.gradle.process.internal.worker.child.WorkerLogEventListener.withWorkerLoggingProtocol(WorkerLogEventListener.java:41)
        at org.gradle.process.internal.worker.request.WorkerAction.run(WorkerAction.java:135)
        at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
        at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
        at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
        at org.gradle.internal.dispatch.ReflectionDispatch.dispatch(ReflectionDispatch.java:36)
        at org.gradle.internal.dispatch.ReflectionDispatch.dispatch(ReflectionDispatch.java:24)
        at org.gradle.internal.remote.internal.hub.MessageHubBackedObjectConnection$DispatchWrapper.dispatch(MessageHubBackedObjectConnection.java:182)
        at org.gradle.internal.remote.internal.hub.MessageHubBackedObjectConnection$DispatchWrapper.dispatch(MessageHubBackedObjectConnection.java:164)
        at org.gradle.internal.remote.internal.hub.MessageHub$Handler.run(MessageHub.java:414)
        at org.gradle.internal.concurrent.ExecutorPolicy$CatchAndRecordFailures.onExecute(ExecutorPolicy.java:64)
        at org.gradle.internal.concurrent.ManagedExecutorImpl$1.run(ManagedExecutorImpl.java:48)
        at org.gradle.internal.concurrent.ThreadFactoryImpl$ManagedThreadRunnable.run(ThreadFactoryImpl.java:56)

```

To reproduce the error just checkout the repo and run it with: 

```shell
./gradlew clean run
```

Checkout the `mn-2.4.x` branch to see that it was working before:

```shell
git checkout mn-2.4.x
./gradlew clean run
```
