package com.yjkstu.forum.controller;


import com.yjkstu.forum.entity.DiscussPost;
import com.yjkstu.forum.entity.Page;
import com.yjkstu.forum.entity.User;
import com.yjkstu.forum.service.DiscussPostService;
import com.yjkstu.forum.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class HomeController {

    @Autowired
    private DiscussPostService discussPostService;

    @Autowired
    private UserService userService;

    /* @RequestMapping(path = "/index", method = RequestMethod.GET)*/
    @GetMapping("/index")
    public String getIndexPage(Model model, Page page) {
        page.setRows(discussPostService.findDiscussPosRows(0));
        page.setPath("/index");
        List<DiscussPost> list = discussPostService.findDiscussPosts(0, page.getOffset(), page.getLimit());
        List<Map<String, Object>> discussPosts = new ArrayList<>();

        if (list != null){
            for (DiscussPost post : list) {
                Map<String, Object> map = new HashMap<>();
                map.put("post", post);
                User user = userService.findUserById(post.getUserId());
                map.put("user", user);
                discussPosts.add(map);
            }
        }
        model.addAttribute("discussPosts", discussPosts);
        return "index";
    }
}
