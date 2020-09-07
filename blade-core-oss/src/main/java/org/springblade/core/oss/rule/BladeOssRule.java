package org.springblade.core.oss.rule;

import lombok.AllArgsConstructor;
import org.springblade.core.tool.utils.DateUtil;
import org.springblade.core.tool.utils.FileUtil;
import org.springblade.core.tool.utils.StringPool;
import org.springblade.core.tool.utils.StringUtil;

/**
 * 默认存储桶生成规则
 *
 * @author Chill
 */
@AllArgsConstructor
public class BladeOssRule implements OssRule {

  @Override
  public String bucketName(String bucketName) {
    return bucketName;
  }

  @Override
  public String fileName(String originalFilename) {
    return "upload" + StringPool.SLASH + DateUtil.today() + StringPool.SLASH + StringUtil
        .randomUUID() + StringPool.DOT + FileUtil.getFileExtension(originalFilename);
  }

}
