package com.nextlive.framework.util;

import android.content.Context;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.os.AsyncTask;

import com.nextlive.framework.global.BaseApp;

public class SoundUtils {
    public static BackgroundSound backgroundSound = null;
    public static MediaPlayer mp;

    public static class BackgroundSound extends AsyncTask<Void, Void, Void> {
        private MediaPlayer mediaPlayer;
        private int sound;

        public BackgroundSound(MediaPlayer mediaPlayer, int sound) {
            this.mediaPlayer = mediaPlayer;
            this.sound = sound;
        }

        protected Void doInBackground(Void... params) {
            try {
                this.mediaPlayer.setVolume((float) this.sound, (float) this.sound);
                this.mediaPlayer.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }
    }

    private static void musicPlayerInit(final int sound) {
        if (mp != null) {
            mp.setOnPreparedListener(new OnPreparedListener() {
                public void onPrepared(MediaPlayer mp) {
                    if (SoundUtils.backgroundSound != null) {
                        SoundUtils.backgroundSound.cancel(true);
                    }
                    SoundUtils.backgroundSound = new BackgroundSound(mp, sound);
                    SoundUtils.backgroundSound.execute(new Void[0]);
                }
            });
            mp.setOnCompletionListener(new OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    SoundUtils.clear();
                }
            });
            mp.setOnErrorListener(new OnErrorListener() {
                @Override
                public boolean onError(MediaPlayer mp, int what, int extra) {
                    if (what == 100 || what == -19) {
                        SoundUtils.clear();
                    }
                    return false;
                }
            });
        }
    }

    public static void clear() {
        if (mp != null) {
            if (mp.isPlaying()) {
                mp.stop();
                mp.reset();
            }
            mp.release();
            mp = null;
        }
    }

    public static void play(int resID) {
        play(resID, 50);
    }

    public static void play(int resID, int sound) {
        try {
            clear();
            mp = MediaPlayer.create(BaseApp.getInstance(), resID);
            musicPlayerInit(sound);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
