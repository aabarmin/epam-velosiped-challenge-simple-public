# Velosiped Challenge

## Table of contents

* [How to use this repository](#how-to-use-this-repository)
* [How to make a for of this repository](#how-to-make-a-fork-of-this-repository)
* [How to get updates of a remote repository](#how-to-get-updates-of-a-remote-repository)

## How to use this repository

It's recommended creating a fork of this repository to work on tasks independently. In this case you'll have your own copy of the repository and all your implementations will stay in your own repository. Of course, this approach has both benefits and drawbacks:

* Benefit - nobody sees your code except yourself.
* Drawback - nobody sees your code except yourself.

## How to make a fork of this repository

To create a fork of this repository press a `Fork` button on the top right of this page. GitHub will ask you about
the location of a newly created repository and next you'll be able to clone the repository to your local machine:

```shell script
$ git clone https://github.com/your-account-name/epam-velosiped-challenge-simple-public
``` 

As a result, you'll have a folder called `epam-velosiped-challenge-simple-public` locally.

## How to get updates of a remote repository

When the fork is created it'll not receive updates automatically, it's necessary making some manual configuration
for your local repository - you need to add a new remote to your local repository. To do it, 
execute the following command:

```shell script
$ git remote add -t main epam http://github.com/aabarmin/epam-velosiped-challenge-simple-public/
```

This command will associate your local repository with one additional remote repository - mine repository. In means
that you can send and receive updates from both remote locations - from mine and from your.

The following command will show what remotes are associated with your local repository:

```shell script
$ git remote show

epam
origin
```  

`origin` is a default name for your remote (`https://github.
com/your-account-name/epam-velosiped-challenge-simple-public`), the `epam` remote is an association with my remote repository (`https://github.com/aabarmin/epam-velosiped-challenge-simple-public`).

The next step is to create a branch that will get updates from my repository. The following command will create
such kind of branch:

```shell script
$ git checkout -b epam_main --track epam/main
```

This command will create a new branch called `epam_main` that receives updates from my repository. You can see the
list of all your branches by executing the following command:

```shell script
$ git branch -a

epam_main
master
```

When you would like to get updates, you need to pull updates from my repository:

```shell script
$ git checkout epam_main
$ git pull
```

And next merge my changes to your `main` branch:

```shell script
$ git checkout main
$ git pull
$ git merge epam_main
```

As a result, your `main` branch will receive updates and new tasks if they're present.

Don't forget to update your remote `main`:

```shell script
$ git push origin main
```