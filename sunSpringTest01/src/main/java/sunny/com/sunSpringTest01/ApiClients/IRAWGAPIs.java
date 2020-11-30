package sunny.com.sunSpringTest01.ApiClients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "rawg", url = "https://api.rawg.io/api")
public interface IRAWGAPIs
{
    @GetMapping(path = "/games")
    ResponseEntity<String> getListGames(
            @RequestHeader("User-Agent") String sUserAgent,
            @RequestParam(value = "page", required = false) Integer page,
            @RequestParam(value = "page_size", required = false) Integer page_size,
            @RequestParam(value = "search", required = false) String search,
            @RequestParam(value = "parent_platforms", required = false) String parent_platforms,
            @RequestParam(value = "platforms", required = false) String platforms,
            @RequestParam(value = "stores", required = false) String stores,
            @RequestParam(value = "developers", required = false) String developers,
            @RequestParam(value = "publishers", required = false) String publishers,
            @RequestParam(value = "genres", required = false) String genres,
            @RequestParam(value = "tags", required = false) String tags,
            @RequestParam(value = "creators", required = false) String creators,
            @RequestParam(value = "dates", required = false) String sDates,
            @RequestParam(value = "platforms_count", required = false) Integer platforms_count,
            @RequestParam(value = "exclude_collection", required = false) Integer exclude_collection,
            @RequestParam(value = "exclude_additions", required = false) Boolean exclude_additions,
            @RequestParam(value = "exclude_parents", required = false) Boolean exclude_parents,
            @RequestParam(value = "exclude_game_series", required = false) Boolean exclude_game_series,
            @RequestParam(value = "ordering", required = false) String ordering
            );
    @GetMapping(path = "/games/{id}")
    ResponseEntity<String> getGameDetails(
            @RequestHeader("User-Agent") String sUserAgent,
            @PathVariable(value = "id", required = true) Integer id
            );
}
