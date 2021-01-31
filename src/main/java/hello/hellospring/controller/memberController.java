package hello.hellospring.controller;
import hello.hellospring.domain.Member;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class memberController {
    private final MemberService memberService;

    //생성자 service와 repository bean등록으로 spring container안에 넣어줌
    @Autowired
    public memberController(MemberService memberService) {
        this.memberService = memberService;
    }

    //조회할때 get
    @GetMapping("/members/new")
    public String createForm() {
        return "Members/createMemberForm";
    }

    //등록할때 post
    @PostMapping("/members/new")
    public String create(MemberForm form) {
        Member member = new Member();
        member.setName(form.getName());
        memberService.join(member);

        return "redirect:/";
    }

    @GetMapping("/members")
    public String list(Model model){
        List<Member> memebers = memberService.findMembers();

        //model에 넣음으로서 ${}로 key를통해 value값 뺄 수 있음
        model.addAttribute("members", memebers);

        return "/Members/memberList";
    }
}