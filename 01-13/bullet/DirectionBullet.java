package com.noma.invader.bullet;


import com.eaglesakura.lib.android.game.math.Vector2;
import com.noma.invader.R;
import com.noma.invader.figther.FighterBase;
import com.noma.invader.scene.GameSceneBase;
import com.noma.invader.scene.PlaySceneBase;

public class DirectionBullet extends BulletBase {
    /**
     * 1フレームごとの移動量を保持する。
     */
    Vector2 offset = new Vector2(0, 10);

    public DirectionBullet(GameSceneBase scene, FighterBase shooter) {
        super(scene, shooter);

        sprite = loadSprite(R.drawable.bullet_enemy); // たまの画像を保持する
        setPosition(shooter.getPositionX(), shooter.getPostionY());
    }

    /**
     * 弾の向かう方向と速度を指定する
     * @param directionDegree
     * @param moveSpeed
     */
    public void setup(float directionDegree, float moveSpeed) {
        // radianを求める
        final double radian = Math.toRadians(directionDegree + 90);

        // x移動量 = cos(radian) * 移動速度
        // y移動量 = sin(radian) * 移動速度
        offset.set((float) Math.cos(radian) * moveSpeed, (float) Math.sin(radian) * moveSpeed);

        //! yは計算と上下が逆になる
        offset.y = -offset.y;
    }

    @Override
    public void update() {
        // setupメソッドで計算されたオフセット量だけ移動させる。
        offsetPosition(offset.x, offset.y);
        FighterBase player = ((PlaySceneBase) scene).getPlayer();

        // プレイヤーと弾が衝突していたらダメージ処理を行う
        if (player.isIntersect(this)) {
            enable = false;
            player.onDamage(this);
        }
    }
}
