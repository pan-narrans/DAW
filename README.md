# DAW
Ejercicios y archivos del grado de DAW
|Table of Contents|
| --- |
| [Commit Rules](https://github.com/pan-narrans/DAW#commit-rules) |
| [Git Commands](https://github.com/pan-narrans/DAW#git-commands) |



## Commit rules
* `[commit object] - [changes description]`
* Commits tart with a capital letter
* Brief description of changes made to see them at first glance in folder view
* Change only one course at a time

## Git Commands

|Objective|Command|Why|
| :--- | :--- | :--- |
|Clone Repo|`$ git clone https://github.com/pan-narrans/DAW.git`|Clones the repository in the current folder.
|Set upstream branch|`$ git push -u <remote> <branch>`|The easiest way to set the upstream branch is to use the “git push” command with the “-u” option for upstream branch.|
|Set cool alias|`$ git config --global alias.prettylog "log --graph --abbrev-commit --decorate --format=format:'%C(bold blue)%h%C(reset) - %C(bold green)(%ar)%C(reset) %C(white)%s%C(reset) %C(dim white)- %an%C(reset)%C(bold yellow)%d%C(reset)' --all"`|I want to see the branches clearly from the console|
