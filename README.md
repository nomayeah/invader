・Fork
=>　左上「Fork」をクリック自分のリポジトリ作成

・自分のリポジトリをクローン
=>　「Forkした自分のリポジトリ」を緑色の「画面右中のClone or download」をクリック
=>　「https://github.com/〜〜〜〜〜〜〜〜/invader.git」的なテキストをコピー
=>　コマンドプロントを起動
=>　デスクトップにフォルダを作成して、「cd 」をコマンドを打ってからフォルダをドラッグアンドドロップ、エンター
    （例：　cd /Users/y_nonaka/Desktop/〜〜〜〜〜〜〜）こんなんなるはず
=>　ディレクトリ移動したら　先ほどコピーしたテキストを「git clone 〜〜〜〜」と打ち込む
    （例：git clone https://github.com/〜〜〜〜〜〜〜〜/invader.git）

・オリジナルのリポジトリを設定
=>　「git remote add upstream https://github.com/nomayeah/invader.git」

・pullして最新版に更新する
=>　「git pull upstream master」


