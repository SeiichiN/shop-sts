# shop-sts
Demo application of Spring Tool Suite 4

## mainとmaster
最初にgithubにてリポジトリを作成。
次にローカルにて git init にて .git ディレクトリを作成。
すると、master になっている。

## 対応1
ローカルにて master を main に名前を変えてみた。
git branch -m master main
それでやってみたけど、うまくいかなかった。
ローカルのmain と リモートのmain がうまく調和してくれない。

## 対応2
STS4上で git clone でリモートのリポジトリをコピーする。
それを STS4 で作業したが、うまくいかなかった。

## 結論
master のままで続行。

