package com.noma.invader.fighter.enemy;

import com.noma.invader.fighter.FighterBase;
import com.noma.invader.scene.GameSceneBase;

public abstract class EnemyFighterBase extends FighterBase {
    /**
     * 生成されてからのフレームを記録する
     */
    protected int frameCount = 0;

    public EnemyFighterBase(GameSceneBase scene) {
        super(scene);
    }

    /**
     * フレーム数のカウンターを０に戻す
     */
    protected void resetFrameCount() {
        frameCount = 0;
    }

    @Override
    public void update() {
        ++frameCount;
    }

    @Override
    public void draw() {
        if (isDead()) {
            return;
        }
        super.draw();
    }
}
