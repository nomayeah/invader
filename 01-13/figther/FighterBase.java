package com.noma.invader.figther;

import android.graphics.Rect;

import com.noma.invader.GameSprite;
import com.noma.invader.bullet.BulletBase;
import com.noma.invader.scene.GameSceneBase;


public abstract class FighterBase extends GameSprite {

    /**
     * 戦闘機のヒットポイント
     * デフォルトは１
     */
    protected int hp = 1;

    public FighterBase(GameSceneBase scene){
        super(scene);
    }

    /**
     * ２つのスプライトが衝突している場合、trueを返す
     */
    public boolean isIntersect(GameSprite other) {
        if (isDead()) {
            // 撃墜済みの戦闘機にあたり判定は発生しない
            return false;
        }
        Rect mySpriteArea = getSprite().getDstRect();
        Rect otherSpriteArea = other.getSprite().getDstRect();
        return Rect.intersects(mySpriteArea, otherSpriteArea);
    }
    /**
     * 弾が当たったらこのメソッドに通知される
     */
    public void onDamage(BulletBase bullet) {
        --hp;
    }

    /**
     * この機体が撃墜されていたらtrueを返す
     */
    public boolean isDead() {
        return hp <= 0;
    }
}
