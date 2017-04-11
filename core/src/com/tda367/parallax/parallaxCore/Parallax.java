package com.tda367.parallax.parallaxCore;

import com.tda367.parallax.parallaxCore.course.Course;
import com.tda367.parallax.parallaxCore.spaceCraft.ISpaceCraft;

import java.util.List;

/**
 * Created by Anthony on 05/04/2017.
 */
public class Parallax implements Updatable{

    private RenderManager renderManager;
    private Course course;
    private Camera camera;

    public Parallax(Player player){
        renderManager = RenderManager.getInstance();

        course = new com.tda367.parallax.parallaxCore.course.Course();
        course.addSpaceCraft(player.getSpaceCraft());

        camera = new Camera();
        camera.trackTo(player.getSpaceCraft());


    }

    @Override
    public void update(int milliSinceLastUpdate) {
        course.update(milliSinceLastUpdate);
        camera.update(milliSinceLastUpdate);
    }

    public List<ISpaceCraft> getSpaceCraft(){
        return course.getSpaceCrafts();
    }

    public RenderManager getRenderManager(){
        return renderManager;
    }

    public Camera getCamera(){
        return camera;
    }
}
