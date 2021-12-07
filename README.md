# Velosiped Challenge

## Table of contents

* [How to use this repository](#how-to-use-this-repository)
* [How to make a for of this repository](#how-to-make-a-fork-of-this-repository)
* [How to get updates of a remote repository](#how-to-get-updates-of-a-remote-repository)
* [What is a task?](#what-is-the-task)
* [How to solve a task?](#how-to-solve-a-task)

## How to use this repository

It's recommended creating a fork of this repository to work on tasks independently. In this case you'll have your own copy of the repository and all your implementations will stay in your own repository. Of course, this approach has both benefits and drawbacks:

* Benefit - nobody sees your code except yourself.
* Drawback - nobody sees your code except yourself.

## How to make a fork of this repository

To create a fork of this repository press a `Fork` button on the top right of this page. GitHub will ask you about
the location of a newly created repository and next you'll be able to clone the repository to your local machine:

```shell
$ git clone https://github.com/your-account-name/epam-velosiped-challenge-simple-public
``` 

As a result, you'll have a folder called `epam-velosiped-challenge-simple-public` locally.

## How to get updates of a remote repository

When the fork is created it'll not receive updates automatically, it's necessary making some manual configuration
for your local repository - you need to add a new remote to your local repository. To do it, 
execute the following command:

```shell
$ git remote add -t main epam http://github.com/aabarmin/epam-velosiped-challenge-simple-public/
```

This command will associate your local repository with one additional remote repository - mine repository. In means
that you can send and receive updates from both remote locations - from mine and from your.

The following command will show what remotes are associated with your local repository:

```shell
$ git remote show

epam
origin
```  

`origin` is a default name for your remote (`https://github.
com/your-account-name/epam-velosiped-challenge-simple-public`), the `epam` remote is an association with my remote repository (`https://github.com/aabarmin/epam-velosiped-challenge-simple-public`).

The next step is to create a branch that will get updates from my repository. The following command will create
such kind of branch:

```shell
$ git checkout -b epam_main --track epam/main
```

This command will create a new branch called `epam_main` that receives updates from my repository. You can see the
list of all your branches by executing the following command:

```shell
$ git branch -a

epam_main
master
```

When you would like to get updates, you need to pull updates from my repository:

```shell
$ git checkout epam_main
$ git pull
```

And next merge my changes to your `main` branch:

```shell
$ git checkout main
$ git pull
$ git merge epam_main
```

As a result, your `main` branch will receive updates and new tasks if they're present.

Don't forget to update your remote `main`:

```shell
$ git push origin main
```

## What is the task

Any task in this repository consists of three parts:
1. Description.
2. An interface for the implementation.
3. Tests for the task.

The first part, the description is in JavaDoc of the interface, but anyway it's important to mention it here. The second
part is the interface that declares a contract between a task and the solution. All the interfaces are in the
`src/main/java` folder and look like this:

```java
/**
 * Task 1 - Simple GET calculator.
 *
 * <p>
 *   Implement a simple <pre>/sum</pre> endpoint which should receive requests via GET. The request
 *   contains parameters <pre>a</pre> and <pre>b</pre> which are two numbers which should be sum. 
 *   The result of the sum should be returned back to the user. 
 * </p>
 *
 * <p>
 *   The interface has two methods - <pre>startServer</pre> which starts a web server on a given
 *   port and the <pre>stopServer</pre> method which stops the server.
 * </p>
 *
 * @author Aleksandr Barmin
 */
public interface VelosipedTask1 {
  /**
   * Start a server on a given port. 
   *
   * @param port number
   */
  void startServer(int port);

  /**
   * Stop a started server.
   */
  void stopServer();
}
``` 

The most important part of the task is a collection of tests that checks your implementation. Tests are stored in the
`src/test/java` folder and has a name like the task name plus `Test` like `VelosipedTask1Test`.

Tests are ordinary JUnit tests:

```java
class VelosipedTask1Test {
  private VelosipedTask1 uut = VelosipedHelper.getInstance(VelosipedTask1.class);

  @BeforeEach
  void setUp() {
    uut.startServer(1234);
  }

  @AfterEach
  void tearDown() {
    uut.stopServer();
  }

  @ParameterizedTest
  @CsvSource({
      "1,2",
      "10,20",
      "-1,-2"
  })
  void check_calculation(int a, int b) throws Exception {
    // code of the test is here
  }
}
```

## How to solve a task

First of all, it's better working on the separate task in its own branch. To create a separate branch, execute
the following command:

```shell script
$ git checkout main
$ git checkout -b <task-number>
```

In order to solve the task, it's necessary writing an implementation class that is in the same package as the interface
and has a name with `Impl` at the end. This implementation should implement the interface of the task.

```java
public class VelosipedTask1Impl implements VelosipedTask1 {
  @Override
  public void startServer(int port) {
    // TODO, add your implementation here
  }

  @Override
  public void stopServer() {
    // TODO, add your implementation here
  }
}
```

When all the tests are passed, don't forget to create a commit and push your changes to the remote repository:

```shell script
$ git commit
$ git push --set-upstream <remote_name> <task-number>
```

The last one step is to go to the GitHub page of your repository and create a merge request from your task branch
to the master branch of your repository. It'll allow you to send your code for review to your colleagues or friends
on the one hand and on the other hand you'll be able to take one more look into your code later. When the code is
completed, you'll merge the task branch to the `main` branch.

Updates from your remote `main` branch can be received using the following command:

```shell script
$ git checkout main
$ git pull
```

Git looks quite complicated, but the following resources will help you be familiar with it shortly:
* [ProGit](https://git-scm.com/book/en/v2)
* [Git Cheat Sheet](https://github.github.com/training-kit/downloads/github-git-cheat-sheet.pdf)